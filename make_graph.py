import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
import numpy as np
import os

paths = os.listdir('output')


def compare_algorithm_times_plot(dic):
    for key, value_dic in dic.items():
        plot1 = plt.figure(1, figsize=(9, 6))
        make_plot_time(value_dic['best'], key)
        plt.title('best case')
        plot2 = plt.figure(2, figsize=(9, 6))
        make_plot_time(value_dic['average'], key)
        plt.title('average case')
        plot3 = plt.figure(3, figsize=(9, 6))
        make_plot_time(value_dic['worst'], key)
        plt.title('worst case')

    plot1.savefig(os.path.join('plot', 'best_time_comparison.png'))
    plot2.savefig(os.path.join('plot', 'average_time_comparison.png'))
    plot3.savefig(os.path.join('plot', 'worst_time_comparison.png'))

    plt.close()


def compare_algorithm_count_plot(dic):
    for key, value_dic in dic.items():
        plot1 = plt.figure(4, figsize=(9, 6))
        make_plot_count(value_dic['best'], key)
        plt.title('best case')
        plot2 = plt.figure(5, figsize=(9, 6))
        make_plot_count(value_dic['average'], key)
        plt.title('average case')
        plot3 = plt.figure(6, figsize=(9, 6))
        make_plot_count(value_dic['worst'], key)
        plt.title('worst case')

    plot1.savefig(os.path.join('plot', 'best_count_comparison.png'))
    plot2.savefig(os.path.join('plot', 'average_count_comparison.png'))
    plot3.savefig(os.path.join('plot', 'worst_count_comparison.png'))

    plt.close()

def make_plot_count(df, case,):
    size = df['size'].values
    count = df['count'].values
    
    plt.plot(size, count, label=case)
    plt.legend()
    plt.xlabel('n')
    plt.ylabel('count')


def make_plot_time(df, case):
    size = df['size'].values
    time = df['time'].values / 1000.0  # convert to microsecond

    plt.plot(size, time, label=case)
    plt.legend()
    plt.xlabel('n')
    plt.ylabel('time')


def make_plot():
    complexity_dict = {}
    for path in paths:
        df = pd.read_csv(os.path.join('output', path))
        title = path.split('.')[0]

        df_best = df[df['type'] == 'best']
        df_average = df[df['type'] == 'average']
        df_worst = df[df['type'] == 'worst']
        plt.figure(figsize=(9, 6))
        make_plot_time(df_best, 'best')
        make_plot_time(df_average, 'average')
        make_plot_time(df_worst, 'worst')

        plt.title(path.split('.')[0])
        plt.savefig(os.path.join(
            'plot', title + '_time' + '.png'))
        plt.close()

        complexity_dict[title] = {'best': df_best,
                                  'average': df_average,
                                  'worst': df_worst}
        plt.figure(figsize=(9, 6))
        make_plot_count(df_best, 'best')
        make_plot_count(df_average, 'average')
        make_plot_count(df_worst, 'worst')
        plt.title(path.split('.')[0])
        plt.savefig(os.path.join(
            'plot', title + '_count' + '.png'))
        plt.close()

    compare_algorithm_times_plot(complexity_dict)
    compare_algorithm_count_plot(complexity_dict)


def main():
    make_plot()


if __name__ == "__main__":
    main()
