package org.spring.springbootjpareply.service;

import lombok.RequiredArgsConstructor;
import org.spring.springbootjpareply.dto.BoardDto;
import org.spring.springbootjpareply.entity.BoardEntity;
import org.spring.springbootjpareply.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
  // 1.@Autowired 주입
/*  @Autowired
  private BoardRepository boardRepository;*/
  //2. 생성자로 주입
/*  private BoardRepository boardRepository;
  public BoardService(BoardRepository boardRepository){
    this.boardRepository=boardRepository;
  }*/
  //3.@RequiredArgsConstructor
  private final BoardRepository boardRepository;

  // 추가,삭제, 수정
  @Transactional
  public void insertBoad(BoardDto boardDto) {
    // Dto-> Entity
    BoardEntity boardEntity = BoardEntity.toBoardDtoD(boardDto);
    boardRepository.save(boardEntity);
  }

  public List<BoardDto> boardListDo() {
    List<BoardDto> boardDtoList = new ArrayList<>();
    //1. DB -> get
    List<BoardEntity> boardEntityList = boardRepository.findAll();
    for (BoardEntity boardEntity : boardEntityList) {
      // Entity -> Dto
      boardDtoList.add(BoardDto.toBoardDtoDo(boardEntity));
    }
    return boardDtoList;
  }

  @Transactional  // 추가,삭제, 수정
  public void upHitDo(Long id) {
    boardRepository.updateHit(id);
  }

  public BoardDto findByBoard(Long id) {
    Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
    if (optionalBoardEntity.isPresent()) {
      //optionalBoardEntity.get();// 하나의 Entity get
   /*   BoardDto boardDto=BoardDto.toBoardDtoDo(optionalBoardEntity.get());
      return boardDto;*/
      return BoardDto.toBoardDtoDo(optionalBoardEntity.get());
    } else {
        return  null;
    }
  }

}
