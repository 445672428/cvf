package com.templet.word;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.templet.model.Project;
import com.templet.model.ProjectWithImage;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

public class DocxProjectWithFreemarkerAndImageWithoutImageProvider {
	  public static void main( String[] args )
	    {
	        try
	        {
	            // 1) Load Docx file by filling Freemarker template engine and cache
	            // it to the registry
	            InputStream in =
	                DocxProjectWithFreemarkerAndImageWithoutImageProvider.class.getResourceAsStream( "DocxProjectWithFreemarkerAndImageWithoutImageProvider.docx" );
	            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );

	            // 2) Create fields metadata to manage image
	            FieldsMetadata metadata = report.createFieldsMetadata();
	            // Image from InputStream (can works too with byte[])
	            // Old API
	            /*
	             * metadata.addFieldAsImage( "logo", "project.logo" );
	             * metadata.addFieldAsImage( "imageNotExistsAndRemoveImageTemplate", "project.nullLogo",
	                                      NullImageBehaviour.RemoveImageTemplate );
	            
	            metadata.addFieldAsImage( "imageNotExistsAndKeepImageTemplate", "project.nullLogo",
	                                      NullImageBehaviour.KeepImageTemplate );
	            // Image from File
	            metadata.addFieldAsImage( "logoFile", "project.logoFile" );
	            
	            metadata.addFieldAsImage( "fileImageNotExistsAndRemoveImageTemplate", "project.nullLogoFile",
	                                      NullImageBehaviour.RemoveImageTemplate );
	            
	            metadata.addFieldAsImage( "fileImageNotExistsAndKeepImageTemplate", "project.nullLogoFile",
	                                      NullImageBehaviour.KeepImageTemplate );
	             */
	            // NEW API which use @FieldMetadata
	            metadata.load( "project", ProjectWithImage.class);
	            
	            // 3) Create context Java model
	            IContext context = report.createContext();
	            Project project = new ProjectWithImage( "XDocReport" );
	            context.put( "project", project );

	            // 4) Generate report by merging Java model with the Docx
	            OutputStream out =
	                new FileOutputStream( new File( "DocxProjectWithFreemarkerAndImageWithoutImageProvider_Out.docx" ) );

	            report.process( context, out );
	        }
	        catch ( IOException e )
	        {
	            e.printStackTrace();
	        }
	        catch ( XDocReportException e )
	        {
	            e.printStackTrace();
	        }
	    }
}
