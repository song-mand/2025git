#include <iostream>
#include <cmath>
#include <cstdlib>

using namespace std;

void factorial(long long n){
    if (n>0)
    {
        long long fact=n;
        for (long long i=fact-1;i>=1;i--)
        {
            fact=fact*(i);
        }

        cout<<fact<<endl;
    
        
    }
    
    else{
        cout<<1<<endl;
    }
}
int main(){
    long long k;
    cin>>k;
    factorial(k);
    return 0;
}