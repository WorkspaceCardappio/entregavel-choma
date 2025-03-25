package br.com.cardappio.client;

import br.com.cardappio.dto.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "smtp", url = "localhost:8081/api/emails")
public interface SMTPFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/send")
    void sendEmail(@RequestBody EmailRequest request);
}
