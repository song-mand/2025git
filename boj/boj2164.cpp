#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
   
    int n;
    cin>>n;
    vector<int> v;
    for (int i=1;i<=n;i++)
    {
        v.push_back(i);
    }
    while(v.size()!=1)
    {
        
        v.erase(v.begin());
        v.push_back(v[0]);
        v.erase(v.begin());
    }
    cout<<v[0]<<endl;
    return 0;
}