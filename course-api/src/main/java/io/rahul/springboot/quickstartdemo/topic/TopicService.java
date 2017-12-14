package io.rahul.springboot.quickstartdemo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("SPR", "Spring", "Spring tutorial"),
			new Topic("HIB", "Hibernate", "Hibernate tutorial"),
			new Topic("AWS", "AWS", "Cloud tutorial")
			));
	
	public List<Topic> getTopics() {
		return topics;
	}
	
	public Topic getTopicbyId(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
