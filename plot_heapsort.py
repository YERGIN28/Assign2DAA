import pandas as pd
import matplotlib.pyplot as plt


df = pd.read_csv("metrics_heapsort.csv")


df["time_ms"] = df["time_ns"] / 1_000_000

# ---------- TIME VS N ----------
plt.figure()
plt.plot(df["n"], df["time_ms"], marker='o', color='blue')
plt.title("HeapSort - Time vs Input Size (n)")
plt.xlabel("Input Size (n)")
plt.ylabel("Time (ms)")
plt.grid(True)
plt.savefig("docs/performance-plots/heapsort_time_vs_n.png", dpi=200)

# ---------- COMPARISONS VS N ----------
plt.figure()
plt.plot(df["n"], df["comparisons"], marker='o', color='orange')
plt.title("HeapSort - Comparisons vs Input Size (n)")
plt.xlabel("Input Size (n)")
plt.ylabel("Comparisons")
plt.grid(True)
plt.savefig("docs/performance-plots/heapsort_comparisons_vs_n.png", dpi=200)

# ---------- SWAPS VS N ----------
plt.figure()
plt.plot(df["n"], df["swaps"], marker='o', color='green')
plt.title("HeapSort - Swaps vs Input Size (n)")
plt.xlabel("Input Size (n)")
plt.ylabel("Swaps")
plt.grid(True)
plt.savefig("docs/performance-plots/heapsort_swaps_vs_n.png", dpi=200)

plt.show()
