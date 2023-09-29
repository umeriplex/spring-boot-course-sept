package tecqasr.spring.app.tecqasrcontent.repository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import tecqasr.spring.app.tecqasrcontent.model.Content;
import tecqasr.spring.app.tecqasrcontent.model.Status;
import tecqasr.spring.app.tecqasrcontent.model.Type;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();
    ContentCollectionRepository(){};

    public List<Content> getContentList() {
        return contentList;
    }

    public Optional<Content> getContentById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }


    public void addContent(Content content) {
        contentList.add(content);
    }

    public void deleteContentById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }

    public void updateContentById(Integer id, Content content) {
        Optional<Content> contentOptional = getContentById(id);
        if (contentOptional.isPresent()) {
            contentList.removeIf(c -> c.id().equals(id));
            contentList.add(content);
        }
    }


    @PostConstruct
    private void init(){
        Content c1 = new Content(
                1,
                "title1",
                "description1",
                Status.PUBLISHED,
                Type.ARTICLE,
                LocalDate.now(),
                null,
                "url1"
        );
        contentList.add(c1);
    }

}
