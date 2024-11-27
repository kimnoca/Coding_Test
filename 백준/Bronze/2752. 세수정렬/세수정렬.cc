#include <iostream>
#include <algorithm>

using namespace std;


int main() {

	int n1 = 0;
	int	n2 = 0;
	int n3 = 0;
	int arr[3];
	cin >> n1;
	cin >> n2;
	cin >> n3;
	arr[0] = n1;
	arr[1] = n2;
	arr[2] = n3;

	sort(arr, arr + 3);

	for (int i = 0; i < 3; i++) {
		cout << arr[i] << " ";
	}


}
