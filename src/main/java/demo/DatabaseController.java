package demo;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DatabaseController {
	
	@Autowired
	UserRepository userRepo;

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

//    @RequestMapping(value="/upload", method=RequestMethod.POST)
//    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
//            @RequestParam("file") MultipartFile file){
//        if (!file.isEmpty()) {
//            try {
////                byte[] bytes = file.getBytes();
////                BufferedOutputStream stream =
////                        new BufferedOutputStream(new FileOutputStream(new File(name)));
////                stream.write(bytes);
////                stream.close();
//                
//              
//            	byte[] bytes = file.getBytes();
//                    // Creating the directory to store file
//                    String fileName = file.getOriginalFilename();
//                    String fileExtension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
//                    File dir = new File("/Users/badrionapple/Documents/workspace-sts-3.6.3.SR1/FileUploadDemo/UPLOADED");
//                    if (!dir.exists())
//                        dir.mkdirs();
//     
//                    // Create the file on server
//                    File serverFile = new File(dir.getAbsolutePath()
//                            + File.separator+name+fileExtension);
//                    BufferedOutputStream stream = new BufferedOutputStream(
//                            new FileOutputStream(serverFile));
//                    stream.write(bytes);
//                    stream.close();
//     
//                    logger.info("Server File Location="
//                            + serverFile.getAbsolutePath());
//     
//                    String message = "You successfully uploaded file=" + name
//                            + "<br />";
//                
//                return message;
//                
//            } catch (Exception e) {
//                return "You failed to upload " + name + " => " + e.getMessage();
//            }
//        } else {
//            return "You failed to upload " + name + " because the file was empty.";
//        }
//    }
//    
//    @RequestMapping(value="/download", method=RequestMethod.GET)
//    public ResponseEntity<InputStreamResource> download(HttpServletResponse response) {
//    	
//    	 try {
//    		 String fullPath = "/Users/badrionapple/Documents/workspace-sts-3.6.3.SR1/FileUploadDemo/UPLOADED/witai.pptx";
//    		    File file = new File(fullPath);
//    	      // get your file as InputStream
//    	     // InputStream is = ...;
//    		    HttpHeaders respHeaders = new HttpHeaders();
//    		    respHeaders.setContentDispositionFormData("attachment", "witai.pptx");
//    		    //Path source = Paths.get(fullPath);
//    		    //String mimeType = Files.probeContentType(source);
//    		    		//context.getMimeType(fullPath);
//    		    respHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//    		    //response.setContentType(mimeType);
//    		    InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
//    		    return new ResponseEntity<InputStreamResource>(isr,respHeaders,HttpStatus.OK);
//    	      // copy it to response's OutputStream
//    	    //  org.apache.commons.io.IOUtils.copy(isr, response.getOutputStream());
//    	    //  response.flushBuffer();
//    	    } catch (IOException ex) {
//    	      logger.info("Error writing file to output stream. Filename was '{}'", "", ex);
//    	      throw new RuntimeException("IOError writing file to output stream");
//    	    }
//    	//return new FileSystemResource(myService.getFileFor(fileName)); 
//    	
//    	
//        //return "You can upload a file by posting to this same URL.";
//    }
//    
//    
//    
//    @RequestMapping(value="/delete", method=RequestMethod.PUT)
//    public void delete(HttpServletResponse response) {
//    	try{
//    		 String fullPath = "/Users/badrionapple/Documents/workspace-sts-3.6.3.SR1/FileUploadDemo/UPLOADED/my.pdf";
//    		    File file = new File(fullPath);
//    		    if(file.delete()){
//        			System.out.println(file.getName() + " is deleted!");
//        		}else{
//        			System.out.println("Delete operation is failed.");
//        		}
//    	    } catch (Exception ex) {
//    	      logger.info("Error writing file to output stream. Filename was '{}'", "", ex);
//    	      throw new RuntimeException("IOError writing file to output stream");
//    	    }
//    }
    static Logger log = Logger.getLogger(DatabaseController.class);
    
    @RequestMapping(value="/usertable", method=RequestMethod.GET)
    public @ResponseBody List<Usertable> getUser(HttpServletResponse response) {
    	log.info("user table");
    	return (List<Usertable>) userRepo.findAll();
    }

}
