#include <iostream>
#include <cmath>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;   

int main(){
    vector<int> standline;
    vector<int> subspace;
    int num;
    cin>>num;
    for (int i=0;i<num;i++)
    {
        int temp;
        cin>>temp;
        standline.push_back(temp);
    }//fill elements in standline

    reverse(standline.begin(),standline.end());

    int passnum=1;
    int check=0;
    while (standline[check]!=passnum)
    {
        subspace.push_back(standline[check]);
        standline.pop_back();
        check++;
        
    }
    standline.pop_back();
    passnum++;
    
    while((!subspace.empty())&&(!standline.empty()))
    {
        if(subspace[size(subspace)-1]==passnum)
        {
            subspace.pop_back();
            passnum++;
        }
        else if(standline[size(standline)-1]==passnum)
        {
            standline.pop_back();
            passnum++;
        }
        else if(standline[size(standline)-1]!=passnum)
        {
            subspace.push_back(standline[size(standline)-1]);
            standline.pop_back();
        }
        /*else if(standline.empty()&&(!subspace.empty()))
        {
            cout<<"Sad";
            break;
            return 0;
            
        }*/
       else{
            cout<<"Sad";
            break;
            return 0;
       }
        /*else if(standline.end()!=passnum)
        {
            standline.pop_back();
            passnum++;
        }
        else
        {
            cout<<"Sad";
            return 0;
        }*/

        
    }
    if(subspace.empty()&&standline.empty())
    {
        cout<<"Nice";
    }
    return 0;
    

}