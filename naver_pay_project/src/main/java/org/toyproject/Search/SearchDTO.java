package org.toyproject.Search;

import lombok.*;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {
    String title;
    String url;
    String description;
}
