#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;   

void judge(string s){
    vector<char> v;
    for (int i=0;i<s.size();i++)
    {
        if (s[i]=='(')
        {
            v.push_back(s[i]);
        }
        else if (s[i]==')')
        {
            if (v.empty())
            {
                cout<<"NO"<<endl;
                return;
            }
            else
            {
                v.pop_back();
            }
        }
    }
    if (v.empty())
    {
        cout<<"YES"<<endl;
    }
    else
    {
        cout<<"NO"<<endl;
    }
}

int main(){
    int num;
    cin>>num;
    string ss;
    for (int i=0;i<num;i++)
    {
        cin>>ss;
        judge(ss);
    }
    return 0;
}