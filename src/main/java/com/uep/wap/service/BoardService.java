package com.uep.wap.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uep.wap.model.Board;
import com.uep.wap.repository.BoardRepository;

import java.util.List;

    @Service
    public class BoardService {
        @Autowired
        private BoardRepository boardRepository;

        public List<Board> getAllBoards() {
            return boardRepository.findAll();
        }

        public Board getBoardById(Long id) {
            return boardRepository.findById(id).orElse(null);
        }

        public Board saveBoard(Board board) {
            return boardRepository.save(board);
        }

        public void deleteBoard(Long id) {
            boardRepository.deleteById(id);
        }
    }


