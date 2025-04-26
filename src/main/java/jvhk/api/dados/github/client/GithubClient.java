package jvhk.api.dados.github.client;

import jvhk.api.dados.github.records.RespositoryResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface GithubClient {

    @GetExchange("/user/repos")
    public List<RespositoryResponse> getAllAuthenticatedUserPublicRepositories(@RequestHeader(value = "Authorization", defaultValue = "") String token,
                                                      @RequestHeader(value = "X-GitHub-Api-Version", defaultValue = "2022-11-28") String apiVersion,
                                                      @RequestParam("type") String visibility);

    @GetExchange("/repos/{owner}/{repo}")
    public RespositoryResponse getRepository(@RequestHeader(value = "Authorization", defaultValue = "") String token,
                                                      @RequestHeader(value = "X-GitHub-Api-Version", defaultValue = "2022-11-28") String apiVersion,
                                                      @PathVariable("owner") String owner,
                                                      @PathVariable("repo") String repositoryName);

}
