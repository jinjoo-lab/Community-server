package com.barbel.communityserver.domain.post.service;

import com.barbel.communityserver.domain.post.dto.BoardDto;
import com.barbel.communityserver.domain.post.dto.BoardReplyDto;
import com.barbel.communityserver.domain.post.entity.Board;
import com.barbel.communityserver.domain.post.repository.BoardRepository;
import com.barbel.communityserver.domain.post.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private BoardRepository boardRepository;
    private CommentRepository commentRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository,CommentRepository commentRepository)
    {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
    }

    public BoardReplyDto convert(Board board)
    {
        BoardReplyDto boardDto = new BoardReplyDto();
        boardDto.setTitle(board.getTitle());
        boardDto.setLocation(board.getLocation());
        boardDto.setContent(board.getContent());
        boardDto.setUserId(board.getUserId());
        boardDto.setViews(board.getViews());
        boardDto.setComments(board.getComments());
        return boardDto;
    }

    public List<BoardReplyDto> getAll()
    {
        List<Board> list =  boardRepository.findAll();

        List<BoardReplyDto> boardDtoList = new LinkedList<>();

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
            Board cur = board.get();
            if(cur.getUserId().equals(userId))
            {
                List<String> commentList = cur.getComments();
                for(String commentId : commentList)
                {
                    commentRepository.deleteById(commentId);
                }

                boardRepository.deleteById(id);
            }
        }
    }

    public BoardReplyDto getBoard(String id)
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
