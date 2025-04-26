package jvhk.api.dados.github.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RespositoryResponse(Long id, @JsonProperty("name") String repositoryName, @JsonProperty("html_url") String htmlUrl, @JsonProperty("private") Boolean isPrivate) {
}
