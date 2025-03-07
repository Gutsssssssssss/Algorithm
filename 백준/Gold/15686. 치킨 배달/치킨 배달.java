

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// 치킨 거리 == 집과 가장 가까운 치킨집과의 거리
	// 도시의 치킨 거리 == 모든 집의 치킨 거리의 합
	// 1. 여러 개의 치킨 집 중에서 M 개 고르기
	// 2. M개의 도시의 치킨 거리 계산하기
	// 3. 최소값 찾기
	static final int INF = Integer.MAX_VALUE / 2;
	static int N, M;
	static int[][] arr;
	static List<int[]> chickenList, houseList;
	static int ret = INF;
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		chickenList = new ArrayList<int[]>();
		houseList = new ArrayList<int[]>();
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					houseList.add(new int[] {i, j});
				} else if (arr[i][j] == 2) {
					chickenList.add(new int[] {i, j});
				}
			}
		}
		List<Integer> nums = new ArrayList<Integer>();
		combi(nums, 0);
		System.out.println(ret);
		
	} // main
 	static int solve(List<Integer> nums) {
 		int ret = 0;
 		for (int[] cur : houseList) {
 			int dist = INF;
 			int cy = cur[0];
 			int cx = cur[1];
 			for (int i : nums) {
 				int[] chick = chickenList.get(i);
 				dist = Math.min(dist, Math.abs(chick[0] - cy) + Math.abs(chick[1] - cx));
 			}
 			ret += dist;
 		}
 		return ret;
 	}
 	
 	static void combi(List<Integer> nums, int start) {
 		if (nums.size() == M) {
 			ret = Math.min(ret, solve(nums));
 			return;
 		}
 		int size = chickenList.size();
 		for (int i = start; i < size; i++) {
 			nums.add(i);
 			combi(nums, i + 1);
 			nums.remove(nums.size() - 1);
 		}
 	}
}
