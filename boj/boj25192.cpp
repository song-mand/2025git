#include <iostream>
#include <vector>
#include <string>
#include <algorithm>



using namespace std;

int main()
{
    int num;
    cin >> num;
    vector<string> v;
    string temp;
    
    int imoji=0;
    for (int i = 0; i < num; i++)
    {
        cin >> temp;
        if(temp=="Enter")
        {
            v.clear();
        }
        else{
            if(v.size()!=0)
            {   int check=0;
                for (int j = 0; j < v.size(); j++)
                {
                    if(v[j]==temp)
                    {
                        check++;
                    
                    }

                }
                if(check==0)
                {
                    v.push_back(temp);
                    imoji++;
                }

            }
            else{
                v.push_back(temp);
                imoji++;
            }
        }
    }
    cout<<imoji;
    return 0;

}