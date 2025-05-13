#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
#include <string>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring>

#include <queue>
#include <deque>

using namespace std;

vector<int> v;
int main(){
    int num;
    int temp;
    cin>>num;
    for (int i=0;i<num;i++)
    {
        cin>>temp;
        if (temp==0)
        {
            v.pop_back();
        }
        else
        {
            v.push_back(temp);
        }
    }
    int sum=0;
    for (int i=0;i<v.size();i++)
    {
        sum+=v[i];
    }
    cout<<sum<<endl;
    return 0;
}