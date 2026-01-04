package springweb.model;
import java.util.*;
import org.springframework.stereotype.Component;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {

	private int postId;
	private String postProfile; 
	private String postDesc;
	private Integer reqExperience;
	private List<String> postTechStack;
	

}