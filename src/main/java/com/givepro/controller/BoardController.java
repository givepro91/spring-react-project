package com.givepro.controller;

import com.givepro.common.entity.Board;
import com.givepro.common.repository.BoardRepository;
import com.givepro.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {

    private BoardService boardService;

    @Autowired
    public void setBoard(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public List<Board> getAllBoards() {
        return boardService.getAllBoard();
    }

    @PostMapping("/board")
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

}
