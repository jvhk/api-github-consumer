package jvhk.api.dados.github.controller;

import jvhk.api.dados.github.client.GithubClient;
import jvhk.api.dados.github.client.GithubService;
import jvhk.api.dados.github.records.RespositoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/github")
public class GithubController {

    private GithubClient githubClient;

    public GithubController(GithubClient githubClient){
        this.githubClient = githubClient;
    }

    @Autowired
    private GithubService githubService;

    @GetMapping("/repos")
    public ResponseEntity<List<RespositoryResponse>> getAuthenticatedUserPublicRepositories(){
        List<RespositoryResponse> response = githubClient.getAllAuthenticatedUserPublicRepositories(githubService.getToken(), null, "public");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/repository/{owner}/{repo}")
    public ResponseEntity<RespositoryResponse> getRepositories(@PathVariable("owner") String owner, @PathVariable("repo") String repositoryName){
        RespositoryResponse response = githubClient.getRepository(githubService.getToken(), null, owner, repositoryName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
