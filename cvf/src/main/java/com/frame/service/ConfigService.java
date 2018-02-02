package com.frame.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {
	@Value("${img.src1}")
	public String IMG_SRC1;
	@Value("${img.src2}")
	public String IMG_SRC2;
	@Value("${img.src3}")
	public String IMG_SRC3;
	@Value("${img.src4}")
	public String IMG_SRC4;
}
