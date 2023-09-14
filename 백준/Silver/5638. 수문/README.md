# [Silver I] 수문 - 5638 

[문제 링크](https://www.acmicpc.net/problem/5638) 

### 성능 요약

메모리: 11556 KB, 시간: 76 ms

### 분류

브루트포스 알고리즘, 다이나믹 프로그래밍

### 문제 설명

<p>댐은 n개의 수문을 가지고 있다. 각각의 수문은 자체 용량과 물길을 가지고 있고, 하류에 영향을 줄 수 있다. </p>

<p>수문이 열렸을 때, 영향을 받는 지역은 홍수의 위험이 있다. 수문에 의한 예상 피해액은 지역의 인구의 수와 면적으로 계산할 수 있다.</p>

<p>수문 G<sub>i</sub>의 유량이 F<sub>i</sub> m<sup>3</sup>/hour 이고, 피해 비용이 C<sub>i</sub>라고 하자. 댐에는 물이 Vm<sup>3</sup> 만큼 저장되어 있고, 이 물을 T시간 이내에 모두 비워내야 하는 상황이다. 이때, 수문을 어떻게 열어야 피해 비용이 최소가 되는지를 구하는 프로그램을 작성하시오.</p>

<p>예를 들어, 댐에 수문이 4개가 있고, 각 수문의 유량과 피해 비용이 아래와 같다고 하자.</p>

<table class="table table-bordered" style="width:50%">
	<thead>
		<tr>
			<th style="width:10%">수문</th>
			<th style="width:10%">G<sub>1</sub></th>
			<th style="width:10%">G<sub>2</sub></th>
			<th style="width:10%">G<sub>3</sub></th>
			<th style="width:10%">G<sub>4</sub></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>유량 (m<sup>3</sup>/hour)</td>
			<td>720,000</td>
			<td>50,000</td>
			<td>130,000</td>
			<td>1,200,000</td>
		</tr>
		<tr>
			<td>비용</td>
			<td>120,000</td>
			<td>60,000</td>
			<td>50,000</td>
			<td>150,000</td>
		</tr>
	</tbody>
</table>

<p>물 5백만 m<sup>3</sup>을 7시간 안에 비워내야 하는 경우에, G<sub>1</sub>을 7시간동안 열어 놓으면 되고, 비용은 120,000이 된다. </p>

<p>물 5백만 m<sup>3</sup>을 30시간 안에 비워내야 하는 경우에는 G<sub>2</sub>를 29시간, G<sub>3</sub>를 28시간 동안 열어 놓으면 된다. 이때의 비용은 110,000이 된다.</p>

<p>모든 수문은 항상 독립적으로 동작하며, 수문은 항상 1시간 단위만큼 열 수 있다.</p>

### 입력 

 <p>첫째 줄에 수문의 개수 n이 주어진다. (1 ≤ n ≤ 20) 다음 n개 줄에는 각 수문 G<sub>i</sub>의 유량 (m<sup>3</sup>/hour) F<sub>i</sub>와 피해 비용 C<sub>i</sub>가 주어진다. 다음 줄에는 테스트 케이스의 수 m (1 ≤ m ≤ 50)이 주어진다. 다음 m개 줄에는 V와 T가 주어지며, 물 V m<sup>3</sup>을 T시간 이내에 비워내야 한다는 뜻이다. (1 ≤ F<sub>i</sub>, V, C<sub>i</sub> ≤ 10<sup>9</sup>, 1 ≤ T ≤ 1000)</p>

### 출력 

 <p>각 테스트 케이스마다, 최소 비용을 예제 출력과 같이 출력한다. 만약 물 V를 T시간 이내에 비워낼 수 없으면 "IMPOSSIBLE"을 출력한다.</p>

