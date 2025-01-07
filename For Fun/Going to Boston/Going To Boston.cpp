#include <iostream>
#include <cstdlib>
#include <ctime>
#include <cmath>
using namespace std;

int genRandom(int upper, int lower) {
  return rand() % upper + lower;
}

int main()
{
    srand(time(0));
    const int UPPER = 6;
    const int LOWER = 1;
    int d1 = 0, d2 = 0, d3 = 0, player1 = 0, player2 = 0, p1total = 0, p2total = 0;
    int pot = 20;
    while (pot > 0) {
      cout << "Player 1's turn: " << endl;
      d1 = genRandom(UPPER, LOWER);
      cout << "Die 1: " << d1 << endl;
      d2 = genRandom(UPPER, LOWER);
      cout << "Die 2: " << d2 << endl;
      d3 = genRandom(UPPER, LOWER);
      cout << "Die 3: " << d3 << endl;
      p1total = d1 + d2 + d3;
      cout << "Player 2's turn: " << endl;
      d1 = d2 = d3 = 0;
      d1 = genRandom(UPPER, LOWER);
      cout << "Die 1: " << d1 << endl;
      d2 = genRandom(UPPER, LOWER);
      cout << "Die 2: " << d2 << endl;
      d3 = genRandom(UPPER, LOWER);
      cout << "Die 3: " << d3 << endl;
      p2total = d1 + d2 + d3;
      if (p1total > p2total) {
         pot -= 2;
         player1 += 2;
      }
      else if (p2total > p1total) {
         pot -= 2;
         player2 += 2;
      }
    }
    cout << "Results: " << endl;
    cout << "Player 1 total: " << player1 << endl;
    cout << "Player 2 total: " << player2 << endl;
    if (player1 > player2) {
       cout << "Player 1 wins!" << endl;
    }
    else if (player2 > player1) {
      cout << "Player 2 wins!" << endl;
    }
    else {
      cout << "It's a tie!" << endl;
    }

} 
