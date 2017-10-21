package external.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Value("${ec2.public.url}")
    private String publicUrl;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Public url: " + publicUrl);
    }
}
