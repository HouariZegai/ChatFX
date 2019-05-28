
package com.houarizegai.chatfx.bot;

import java.util.HashMap;
import java.util.Map;

public class ChatBot {
    
    public static Map<String, String> responseBot;
    
    static {
        responseBot = new HashMap<String, String>();
        responseBot.put("hello", "Hi");
        responseBot.put("how are u ?", "i'm fine and u ?");
        responseBot.put("i'm fine", "Nice !");
        responseBot.put("i'm fine what about u ?", "i'm great thanks");
        responseBot.put("thanks", "u always welcome !");
        responseBot.put("nice", "Thanks");
        responseBot.put("nice to meet u", "Glade to meet u too");
        responseBot.put("nice to meet you", "Glade to meet u too");
        responseBot.put("what's your name ?", "I'm Robot");
        responseBot.put("how old are u ?", "21 ys, and u ?");
        responseBot.put("i have 22 ys", "Nice !");
        responseBot.put("22 ys", "Nice !");
        responseBot.put("what's the name of your father ?", "i don't have father");
        responseBot.put("what's the name of your mother ?", "i don't have mother");
        responseBot.put("why ?", "Because i'm robot");
        responseBot.put("good bye", "Bye, see u later :)");
        responseBot.put("good bye ;)", "Bye, see u later :)");
    }
}
