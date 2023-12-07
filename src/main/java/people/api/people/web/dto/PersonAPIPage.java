package people.api.people.web.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonAPIPage<T> {
    private List<T> content;
    @JsonProperty("metadata")
    private PaginationMetadata meta;
    public PersonAPIPage(Page<T> springPage){
        this.content = springPage.getContent();
        this.meta = PaginationMetadata.builder()
        .currPage(springPage.getPageable().getPageNumber())
                .totalPages(springPage.getTotalPages()) // Corrected this line
                .pagesize(springPage.getPageable().getPageSize()) // Added this line
                .totalElements(springPage.getTotalElements())
                .build();
        
    }


    


    @Getter
    @Builder
    private static class PaginationMetadata{
        private Integer currPage;
        private Integer totalPages;
        private Integer pagesize;
        private Long totalElements;
    }
    
}
