#include <iostream>
#include <string>
using namespace std;
int main()
{
    setlocale(LC_ALL, "Russian");
    string str = "Задана строка символов. Вывести на экран только различные слова. Есть строка, на экран.";
    string temp;
    char c;
    size_t pos = 0;
    int i=0;
    while(pos!=string::npos) {
        size_t sop;
        int wordSize = 0;
        while (str[i] != ' ' && str[i] != '.' && str[i] != ',' && str[i] != '(' && str[i] != ')') {
            wordSize++;
            i++;
        }       
        temp = str.substr(pos, wordSize);
        pos += wordSize+1;
        sop = str.find(temp, pos);
        if (sop != string::npos && (str[i] == ' ' || str[i] == '.' || str[i] == ',' || str[i]== '(' || str[i] == ')')) {
            str.erase(sop, wordSize);
        }
        if (str[i] == '.' || str[i] == ',' || str[i] == '(' ||str[i] == ')') {
            i += 2;
            pos++;
        }
        else if (str[i] == ' ')
            i++;
        if (i >= str.size()) {
            break;
        }
    }
    std::cout << str << "\n";
    return 0;
}