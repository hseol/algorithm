#include <iostream>
using namespace std;
 
int N,K;
int ans=0;
int A[11][11]={0};
int JKM[3][21]={0}; //지우,경희,민호의 순번에서 내는 손동작 번호
int WIN[3]={0}; //지우,경희,민호의 승리 회수
int TURN[3]={0}; //지우,경희,민호의 참여 회수(순번)
 
bool jw_number(int num){
    for(int i=0;i<TURN[0];i++)
        if(JKM[0][i]==num)
            return true;
    
    return false;
}
 
void dfs(int p1,int p2){
    
    //지우가 K번 이겼을 때
    if(WIN[0]==K){
        ans=1;
        return;
    }
    
    //경희나 민호가 K번 이겼을 때
    if(WIN[1]==K || WIN[2]==K)
        return;
    
    //지우의 순번동안 N번을 모두 냈거나 이미 정답 나왔을 때
    if(TURN[0]>N || ans==1)
        return;
    
    
    //지우의 순번에서 손동작 번호 정하기
    for(int num=1;num<=N;num++){
        
        //만약 지우가 없다면 반복문 타지 않고 한번만 실행
        if(p1!=0 && p2!=0){
            num=N;
        }else{
            
            //지우의 순번 전까지(TURN[0]) num 있었는지
            if(jw_number(num))
                continue;
            
            JKM[0][TURN[0]]=num; //지우의 순번에서 내는 손동작 번호 설정
        }
        
        int winner=0;
        int turn1=TURN[p1]; //p1이 참여하는 경기 순번
        int turn2=TURN[p2]; //p2가 참여하는 경기 순번
        
        int n1=JKM[p1][turn1];
        int n2=JKM[p2][turn2];
        
        if(A[n1][n2]==2)    winner=p1;
        else if(A[n1][n2]==0)   winner=p2;
        else winner=(p1<p2)? p2:p1; // 우선순위 = 민호(2) > 경희(1) > 지우(0)
 
        TURN[p1]++;
        TURN[p2]++;
        WIN[winner]++;
        dfs(winner,3-(p1+p2));
        WIN[winner]--;
        TURN[p1]--;
        TURN[p2]--;
    }
 
}
 
int main(){
    
    cin>>N>>K;
    for(int i=1;i<=N;i++)
        for(int j=1;j<=N;j++)
            cin>>A[i][j];
    
    for(int i=0;i<20;i++)
        cin>>JKM[1][i];
    
    for(int i=0;i<20;i++)
        cin>>JKM[2][i];
    
    dfs(0,1);
    cout<<ans<<endl;
    
    return 0;
}
 