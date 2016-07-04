package gl.utsav.vendor.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class UploadMultipartFilesData
{

	private List<MultipartFile> files;

	/**
	 * @return the files
	 */
	public List<MultipartFile> getFiles()
	{
		return files;
	}

	/**
	 * @param files
	 *           the files to set
	 */
	public void setFiles(final List<MultipartFile> files)
	{
		this.files = files;
	}

}
