package com.circle.foodstagram.chat.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.circle.foodstagram.chat.model.dto.ChatRoomDTO;

import lombok.extern.log4j.Log4j;

@Repository("chatRoomDao")
@Log4j
public class ChatRoomDao {

	private Map<String, ChatRoomDTO> chatRoomDTOMap;

	@PostConstruct
	private void init() {
		chatRoomDTOMap = new LinkedHashMap<>();
	}

	public List<ChatRoomDTO> findAllRooms() {
		// 채팅방 생성 순서 최근 순으로 반환
		List<ChatRoomDTO> result = new ArrayList<>(chatRoomDTOMap.values());
		Collections.reverse(result);
		log.info("in findAllRooms");
		return result;
	}

	public ChatRoomDTO findRoomById(String id) {
		return chatRoomDTOMap.get(id);
	}

	public ChatRoomDTO createChatRoomDTO(String name) {
		ChatRoomDTO room = ChatRoomDTO.create(name);
		chatRoomDTOMap.put(room.getRoomId(), room);

		return room;
	}
}