package com.eomcs.mylist.dao;

import java.util.ArrayList;
import com.eomcs.mylist.domain.Board;

public abstract class AbstractBoardDao implements BoardDao{

  protected ArrayList boardList = new ArrayList();

  protected abstract void save() throws Exception;

  @Override
  public int countAll() {
    return boardList.size();
  }

  @Override
  public Object[] findAll() {
    return boardList.toArray();
  }

  @Override
  public void insert(Board board)throws Exception{
    boardList.add(board);
    save();
  }

  @Override
  public Board findByNo(int no) {
    if(no <0 || no >= boardList.size()) {
      return null;
    }
    return (Board)boardList.get(no);
  }

  @Override
  public int update(int no, Board board)throws Exception{
    if(no < 0 || no >= boardList.size()) {
      return 0;
    }
    boardList.set(no,board);
    save();
    return 1;
  }

  @Override
  public int delete(int no)throws Exception{
    if(no <0 || no >= boardList.size()) {
      return 0;
    }
    save();
    return 1;
  }

  @Override
  public void increaseViewCount(int no)throws Exception{

    Board board = findByNo(no);
    board.setViewCount(board.getViewCount()+1);
    save();
  }

}