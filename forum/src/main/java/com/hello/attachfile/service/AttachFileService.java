package com.hello.attachfile.service;

import com.hello.attachfile.vo.AttachFileVO;

public interface AttachFileService {
	
	public boolean createAttachFile(AttachFileVO attachFileVO);
	
	public AttachFileVO readOneAttachFileByTopicIdAndFileId(AttachFileVO attachFileVO);
	
	public boolean deleteOneAttachFileByFileId(long fileId);

}
