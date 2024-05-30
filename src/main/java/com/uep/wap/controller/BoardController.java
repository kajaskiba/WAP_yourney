package com.uep.wap.controller;

import com.uep.wap.dto.BoardDTO;
import com.uep.wap.model.Board;
import com.uep.wap.service.BoardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping(path = "/boards")
    public String addBoard(@RequestBody BoardDTO boardDTO) {
        Board board = new Board();
        board.setBoardID(boardDTO.getBoardID());
        board.setTitle(boardDTO.getTitle());
        board.setDescription(boardDTO.getDescription());
        // Add other fields if needed

        boardService.saveBoard(board);
        return "Board added!";
    }

    @GetMapping(path = "/boards")
    public Iterable<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping(path = "/boards/{boardID}")
    public Board findBoardByID(@PathVariable long boardID) {
        return boardService.getBoardById(boardID);
    }

    @DeleteMapping(path = "/boards/{boardID}")
    public void deleteBoardById(@PathVariable long boardID) {
        boardService.deleteBoard(boardID);
    }
}
