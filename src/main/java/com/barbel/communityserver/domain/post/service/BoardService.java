package com.barbel.communityserver.domain.post.service;

import com.barbel.communityserver.domain.post.dto.BoardDto;
import com.barbel.communityserver.domain.post.entity.Board;
import com.barbel.communityserver.domain.post.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository)
    {
        this.boardRepository = boardRepository;
    }

    public BoardDto convert(Board board)
    {
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle(board.getTitle());
        boardDto.setLocation(board.getLocation());
        boardDto.setContent(board.getContent());
        boardDto.setUserId(board.getUserId());
        boardDto.setViews(board.getViews());

        return boardDto;
    }

    public List<BoardDto> getAll()
    {
        List<Board> list =  boardRepository.findAll();

        List<BoardDto> boardDtoList = new LinkedList<>();

        for (Board board : list)
        {
            boardDtoList.add(convert(board));
        }

        return boardDtoList;
    }

    public void saveBoard(BoardDto boardDto)
    {
        Board board = Board.builder().content(boardDto.content).
                location(boardDto.location).title(boardDto.title)
                .userId(boardDto.userId).views(boardDto.views).build();

        boardRepository.save(board);
    }

    public void deleteBoardById(String userId,String id)
    {
        Optional<Board> board = boardRepository.findById(id);

        if(board.isPresent())
        {
            if(board.get().getUserId().equals(userId))
            {
                boardRepository.deleteById(id);
            }
        }
    }

    public BoardDto getBoard(String id)
    {
        Optional<Board> board = boardRepository.findById(id);

        if(board.isPresent())
        {
            return convert(board.get());
        }

        else{
            throw new RuntimeException("해당 내용의 게시판은 존재하지 않습니다.");
        }
    }
}
