package com.hello.attachfile.vo;

/**
 * ATTACH_FILE
 */
public class AttachFileVO {

	private long fileId;

	private int topicId;

	private String originFileName;

	private String uuidFileName;

	private long fileSize;

	private String fileExt;


	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public long getFileId() {
		return this.fileId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getTopicId() {
		return this.topicId;
	}

	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}

	public String getOriginFileName() {
		return this.originFileName;
	}

	public void setUuidFileName(String uuidFileName) {
		this.uuidFileName = uuidFileName;
	}

	public String getUuidFileName() {
		return this.uuidFileName;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public long getFileSize() {
		return this.fileSize;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public String getFileExt() {
		return this.fileExt;
	}

}