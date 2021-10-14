package com.givepro.service;

import com.givepro.common.entity.Board;
import com.givepro.common.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
