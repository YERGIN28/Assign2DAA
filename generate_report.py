import pandas as pd
import matplotlib.pyplot as plt
from reportlab.lib.pagesizes import A4
from reportlab.lib import colors
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Image, Table, TableStyle

# === HeapSort Data ===
heap_data = pd.DataFrame({
    "algorithm": ["HeapSort"] * 4,
    "n": [100, 1000, 5000, 10000],
    "time_ms": [0.438, 0.358, 1.238, 1.975],
    "comparisons": [1024, 16892, 107715, 235271],
    "swaps": [580, 9097, 57145, 124129]
})

# === ShellSort Data (Sedgewick) ===
shell_data = pd.DataFrame({
    "algorithm": ["ShellSort (Sedgewick)"] * 4,
    "n": [100, 1000, 5000, 10000],
    "time_ms": [0.103, 1.602, 1.304, 10.515],
    "comparisons": [718, 13656, 198434, 2616085],
    "swaps": [417, 7960, 110170, 1401727]
})

# === Plot Comparisons ===
def plot_comparison(metric, ylabel, filename):
    plt.figure(figsize=(8,5))
    plt.plot(heap_data["n"], heap_data[metric], marker='o', label="HeapSort")
    plt.plot(shell_data["n"], shell_data[metric], marker='s', label="ShellSort (Sedgewick)")
    plt.xlabel("Input Size (n)")
    plt.ylabel(ylabel)
    plt.title(f"{ylabel} Comparison: HeapSort vs ShellSort")
    plt.legend()
    plt.grid(True)

    path = f"docs/{filename}"
    plt.savefig(path)
    plt.close()
    return path

runtime_plot = plot_comparison("time_ms", "Runtime (ms)", "runtime_comparison.png")
cmp_plot = plot_comparison("comparisons", "Comparisons", "comparisons_comparison.png")
swaps_plot = plot_comparison("swaps", "Swaps", "swaps_comparison.png")

# === Create PDF ===
pdf_path = "docs/analysis-report.pdf"
doc = SimpleDocTemplate(pdf_path, pagesize=A4)
styles = getSampleStyleSheet()
elements = []

# Cover page
elements.append(Paragraph("<b>Design and Analysis of Algorithms – Assignment 2</b>", styles["Title"]))
elements.append(Paragraph("Comparative Report: HeapSort vs ShellSort", styles["Title"]))
elements.append(Spacer(1, 20))
elements.append(Paragraph("Student: <b>Erassul Ginayat (Student B – HeapSort)</b>", styles["Normal"]))
elements.append(Paragraph("Partner: Yerassyl Alimbek (Shell Sort)", styles["Normal"]))
elements.append(Spacer(1, 40))

# Introduction
elements.append(Paragraph("<b>1. Introduction</b>", styles["Heading2"]))
elements.append(Paragraph(
    "This report compares two Divide & Conquer sorting algorithms: HeapSort (implemented by Student B) "
    "and Shell Sort (implemented by Student A). Both algorithms were benchmarked under similar conditions "
    "to evaluate performance in terms of runtime, comparisons, and swaps.", styles["Normal"]))
elements.append(Spacer(1, 20))

# Table of results
elements.append(Paragraph("<b>2. Experimental Results</b>", styles["Heading2"]))
data = [["Algorithm", "n", "Time (ms)", "Comparisons", "Swaps"]] + \
       [list(heap_data.iloc[i]) for i in range(len(heap_data))] + \
       [list(shell_data.iloc[i]) for i in range(len(shell_data))]
table = Table(data)
table.setStyle(TableStyle([
    ('BACKGROUND', (0,0), (-1,0), colors.grey),
    ('TEXTCOLOR',(0,0),(-1,0),colors.whitesmoke),
    ('ALIGN',(0,0),(-1,-1),'CENTER'),
    ('GRID', (0,0), (-1,-1), 0.5, colors.black)
]))
elements.append(table)
elements.append(Spacer(1, 20))

# Graphs
elements.append(Paragraph("<b>3. Performance Graphs</b>", styles["Heading2"]))
for plot in [runtime_plot, cmp_plot, swaps_plot]:
    elements.append(Image(plot, width=400, height=250))
    elements.append(Spacer(1, 15))

# Discussion
elements.append(Paragraph("<b>4. Discussion</b>", styles["Heading2"]))
elements.append(Paragraph(
    "HeapSort exhibits stable O(n log n) performance and predictable runtime growth, while Shell Sort "
    "(especially with the Sedgewick gap sequence) can outperform HeapSort on smaller datasets. "
    "However, as input size increases, HeapSort becomes more consistent and memory-efficient.", styles["Normal"]))
elements.append(Spacer(1, 20))

# Conclusion
elements.append(Paragraph("<b>5. Conclusion</b>", styles["Heading2"]))
elements.append(Paragraph(
    "Both algorithms demonstrate O(n log n) complexity. Shell Sort performs slightly faster on small "
    "inputs, but HeapSort provides more stable and consistent performance for larger datasets. "
    "Overall, HeapSort is preferred for scalability and predictable behavior.", styles["Normal"]))

# Build PDF
doc.build(elements)
print(f"✅ Report saved to {pdf_path}")
