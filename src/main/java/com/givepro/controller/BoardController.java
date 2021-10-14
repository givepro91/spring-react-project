package com.givepro.controller;

import com.givepro.common.entity.Board;
import com.givepro.common.repository.BoardRepository;
import com.givepro.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/board/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @PutMapping("/board/{id}")
    public ResponseEntity<Board> updateBoardById(
            @PathVariable Long id, @RequestBody Board board) {
        return boardService.updateBoard(id, board);
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBoardById(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }

}
