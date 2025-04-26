package jvhk.api.dados.github.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GithubService {

    private final String token;

    public GithubService(@Value("${github.secret}") String secret){
        this.token = secret;
    }

    public String getToken(){
        return this.token;
    }

}
