package people.api.people.web;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import people.api.people.model.Photo;
import people.api.people.repository.PhotoRepository;

@RestController
@RequestMapping(value = "/photo")
public class PhotoController {
    @Autowired
    private PhotoRepository photoRepository;
    // get photo by id

    // @GetMapping(value="/{id}")
    // public ResponseEntity<byte[]> getPhotoById(@PathVariable Long id){
    //     Photo photo= photoRepository.findById(id).get().getContent();
    //     // if(photo.isPresent()){
    //     //     return new ResponseEntity<Photo>(photo.)
    //     // }

    //     return ResponseEntity.ok().headers(HttpHeaders.CONTENT_TYPE,photo.getContentType().))
        
    // }

    @GetMapping(value="")
    public List<Long> getAllPhotos(){
        List<Photo> allPhotos = (List<Photo>) photoRepository.findAll();
        List<Long> allPhotosId = new ArrayList<>();

        for(Photo photo: allPhotos){
          allPhotosId.add(photo.getId());
        }
        return allPhotosId;
    }

    @PostMapping(value="")
    public Photo addPhoto(@RequestParam(name="photo") MultipartFile photofile) throws IOException{
        Photo photo= Photo.builder().description("").content(photofile.getBytes()).build();
        return photoRepository.save(photo);

        
    }


    // get list of all photos

    // upload photo
    
    
}
