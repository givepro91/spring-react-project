package com.givepro.service;

import com.givepro.common.entity.Board;
import com.givepro.common.repository.BoardRepository;
import com.givepro.config.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public void setBoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public ResponseEntity<Board> getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board ID : "+id));
        return ResponseEntity.ok(board);
    }

    public ResponseEntity<Board> updateBoard(Long id, Board updateBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board ID : "+id));
        board.setTitle(updateBoard.getTitle());
        board.setContents(updateBoard.getContents());
        board.setType(updateBoard.getType());
        board.setUpdatedTime(LocalDateTime.now());

        Board endUpdateBoard = boardRepository.save(board);
        return ResponseEntity.ok(endUpdateBoard);
    }

    public ResponseEntity<Map<String, Boolean>> deleteBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board ID : "+id));
        boardRepository.delete(board);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete Board Data by id : " + id, Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
