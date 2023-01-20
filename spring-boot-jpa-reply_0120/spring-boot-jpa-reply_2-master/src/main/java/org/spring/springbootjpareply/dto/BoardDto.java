package org.spring.springbootjpareply.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.springbootjpareply.entity.BoardEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class BoardDto {

  public Long id;  //글번호

  private String title;//글제목

  private String content;//글내용

  private String writer;//글작성자

  private int hit; // 조회수

  private String boardPw;  //글비빌번호 -> 글삭제 시 사용 할 수 있다.

  private LocalDateTime createTime; // 처음 글작성 시간1

  private LocalDateTime updateTime;// 글 수정 시간

  // Entity -> Dto    글목록 , 글상세내역
  public static BoardDto toBoardDtoDo(BoardEntity boardEntity){
        BoardDto boardDto=new BoardDto();// @NoArgsConstructor
        boardDto.setId(boardEntity.getId());
        boardDto.setTitle(boardEntity.getTitle());
        boardDto.setContent(boardEntity.getContent());
        boardDto.setWriter(boardEntity.getWriter());
        boardDto.setHit(boardEntity.getHit());
        boardDto.setBoardPw(boardEntity.getBoardPw());
        boardDto.setCreateTime(boardEntity.getCreateTime());
        boardDto.setUpdateTime(boardEntity.getUpdateTime());

        return boardDto;
  }





}
