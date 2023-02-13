package com.barbel.communityserver.domain.post.controller;

import com.barbel.communityserver.domain.post.dto.BoardDto;
import com.barbel.communityserver.domain.post.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService)
    {
        this.boardService = boardService;
    }

    // 후에 page 단위로 분리할 수 있도록 수정 필요
    @GetMapping()
    public List<BoardDto> getAll()
    {
        return boardService.getAll();
    }

    @GetMapping("/get/{id}")
    public BoardDto getBoard(@PathVariable  String id) throws RuntimeException
    {
        return boardService.getBoard(id);
    }

    @PostMapping("/save")
    public void saveBoard(@RequestBody BoardDto boardDto)
    {
        boardService.saveBoard(boardDto);
    }

    // userId를 개인 정보창에서 가져 올지 , 회원 디비에서 가져 올지 결정 필요
    @GetMapping("/delete/{id}/{userId}")
    public void deleteBoard(@PathVariable String id,@PathVariable String userId)
    {
        boardService.deleteBoardById(userId,id);
    }
}
