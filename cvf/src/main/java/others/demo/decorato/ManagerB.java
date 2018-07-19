package others.demo.decorato;

public class ManagerB extends Manager { 

    public ManagerB(Project project) { 
        super(project); 
    } 

     /** 
     * 项目经理自己的事情：做早期工作 
     */ 
    public void doEarlyWork() { 
    } 

    /** 
     * 项目经理做收尾工作 
     */ 
    public void doEndWork() { 
    } 
}