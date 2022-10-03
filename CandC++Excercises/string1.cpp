#include <string>
#include <clocale>
#include <iostream>
using namespace std;
int main()
{
    setlocale(LC_ALL, "Russian");
    string str = "Найти в строке указанную подстроку и заменить ее на новую";
    string strToReplace = "подстроку";
    string strToReplaceWith = "новую";
    size_t pos = 0;
    while ((pos = str.find(strToReplace, pos)) != string::npos) {
        str.replace(pos, strToReplace.size(), strToReplaceWith);
        pos += strToReplaceWith.size();
    }
    cout << str << "\n";
    return 0;
}