package yt.akka.controller;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yt.akka.akkaproducer.SpringExtProvider;

/**
 * @author yunteng
 */
@RestController
public class AkkaController {

	@Autowired
	private ActorSystem actorSystem;

	@GetMapping("akka-send")
	public void getAllUserInfo(){

		ActorRef actorRef = actorSystem.actorOf(SpringExtProvider.getInstance().get(actorSystem).create("receiveActor"), "receiveActor");
		actorRef.tell("hello world",ActorRef.noSender());
	}
}
