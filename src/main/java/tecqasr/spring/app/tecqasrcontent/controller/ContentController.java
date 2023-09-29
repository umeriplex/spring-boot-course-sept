package tecqasr.spring.app.tecqasrcontent.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tecqasr.spring.app.tecqasrcontent.model.Content;
import tecqasr.spring.app.tecqasrcontent.repository.ContentCollectionRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository contentCollectionRepository;

    public ContentController(ContentCollectionRepository contentCollectionRepository) {
        this.contentCollectionRepository = contentCollectionRepository;
    }

    // make rest api to get all content
    @CrossOrigin()
    @GetMapping("")
    public List<Content> getAllContent() {
        return contentCollectionRepository.getContentList();
    }


    @GetMapping("/{id}")
    public Content getContentById(@PathVariable Integer id) {
        return contentCollectionRepository.getContentById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NO_CONTENT,"Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void addContent(@Valid @RequestBody Content content) {
        contentCollectionRepository.addContent(content);
    }

    @DeleteMapping("/{id}")
    public void deleteContentById(@PathVariable Integer id) {
        contentCollectionRepository.deleteContentById(id);
    }

    @PutMapping("/{id}")
    public void updateContentById(@PathVariable Integer id, @Valid @RequestBody Content content) {
        contentCollectionRepository.updateContentById(id, content);
    }

}
