package leetCode.exam;

import org.junit.Assert;

public class IandPerimeter {

    int[][] mygrid;
    int side=0;
    int row=0,col=0;
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        int x=0,y=0;
        int fx=0,fy=0;
        for(int[] is: grid){
            x=0;
            for(int i : is){
                if (i==1){
                    sum++;
                    if(sum==1){
                        fx=x;
                        fy=y;
                    }
                }
                x++;
            }
            y++;
        }
        mygrid =grid;
        row=y;
        col=x;
        findDoubleSide(fy,fx);
        return 4*sum-2*side;
    }

    public void findDoubleSide(int x,int y){
        if (x <0 ||y<0 ||x>=row||y>=col||mygrid[x][y]==0){
            return;
        }
        if(x-1>-1&&mygrid[x-1][y]==1){
            side++;
        }
        if(x+1<row&&mygrid[x+1][y]==1){
            side++;
        }
        if(y-1>-1&&mygrid[x][y-1]==1){
            side++;
        }
        if(y+1<col&&mygrid[x][y+1]==1){
            side++;
        }
        mygrid[x][y]=0;
        findDoubleSide(x,y-1);
        findDoubleSide(x,y+1);
        findDoubleSide(x-1,y);
        findDoubleSide(x+1,y);
    }

    public static void main(String[] args) {
        IandPerimeter iandPerimeter = new IandPerimeter();
//rectangleArea
//        Assert.assertEquals(4,iandPerimeter.islandPerimeter(new int[][]{{1,0}}));
        Assert.assertEquals(16,iandPerimeter.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }
}
