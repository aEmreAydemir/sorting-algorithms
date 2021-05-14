import pandas as pd
from scipy.interpolate import make_interp_spline, BSpline
import matplotlib.pyplot as plt
import numpy as np
import os

paths = os.listdir('output')
title = None

def check_dir(path):
    if not os.path.exists(path):
        os.makedirs(path)

def compare_algorithm_plot(dic, time_plot=True):
    for key, value_dic in dic.items():
        plot1 = plt.figure(1, figsize=(9, 6))
        make_plot_all(value_dic['best'], key, time_plot)
        plt.title('best case')
        plot2 = plt.figure(2, figsize=(9, 6))
        make_plot_all(value_dic['average'], key, time_plot)
        plt.title('average case')
        plot3 = plt.figure(3, figsize=(9, 6))
        make_plot_all(value_dic['worst'], key, time_plot)
        plt.title('worst case')

    label = 'time' if time_plot else 'count'
    check_dir('plot\\algorithm_comparison')
    plot1.savefig(os.path.join('plot\\algorithm_comparison',
                  'best_' + label + '_comparison.png'))
    plot2.savefig(os.path.join('plot\\algorithm_comparison',
                  'average_' + label + '_comparison.png'))
    plot3.savefig(os.path.join('plot\\algorithm_comparison',
                  'worst_' + label + '_comparison.png'))

    plt.close()
    plt.close()
    plt.close()


def make_plot_all(df, case, time_plot=True):
    size = df['size'].values
    time = df['time'].values
    count = df['count'].values
    input_type = df['input_type'].values[0]
    y = time if time_plot else count
    ylabel = 'time' if time_plot else 'count'
    case = case + '-' + input_type

    xnew = np.linspace(size.min(), size.max(), 500)
    spl = make_interp_spline(size, y, k=3)
    power_smooth = spl(xnew)

    plt.plot(xnew, power_smooth, label=case)
    plt.legend()
    plt.xlabel('n')
    plt.ylabel(ylabel)


def make_plot(df, case, time_plot=True):
    plt.figure(figsize=(9, 6))
    size = df['size'].values
    time = df['time'].values
    count = df['count'].values
    input_type = df['input_type'].values[0]
    y = time if time_plot else count
    ylabel = 'time' if time_plot else 'count'
    label = case + '-' + input_type

    xnew = np.linspace(size.min(), size.max(), 500)
    spl = make_interp_spline(size, y, k=3)
    power_smooth = spl(xnew)

    plt.title(case + ' case')
    plt.plot(xnew, power_smooth, label=label)
    plt.legend()
    plt.xlabel('n')
    plt.ylabel(ylabel)
    plt.savefig(os.path.join(
        'plot\\algorithm_info\\' + title, case + f'_{ylabel}' + '.png'))
    plt.close()
    pass


def data_plot():
    complexity_dict = {}
    for path in paths:
        df = pd.read_csv(os.path.join('output', path))
        global title
        title = path.split('.')[0]
        check_dir(os.path.join('plot\\algorithm_info', title))

        df_best = df[df['type'] == 'best']
        df_average = df[df['type'] == 'average']
        df_worst = df[df['type'] == 'worst']
        plt.figure(figsize=(9, 6))
        make_plot_all(df_best, 'best')
        make_plot(df_best, 'best')
        make_plot_all(df_average, 'average')
        make_plot(df_average, 'average')
        make_plot_all(df_worst, 'worst')
        make_plot(df_worst, 'worst')

        plt.title(title)
        plt.savefig(os.path.join(
            'plot\\algorithm_info\\' + title, 'all_cases_time' + '.png'))
        plt.close()

        complexity_dict[title] = {'best': df_best,
                                  'average': df_average,
                                  'worst': df_worst}
        plt.figure(figsize=(9, 6))
        make_plot_all(df_best, 'best', time_plot=False)
        make_plot(df_best, 'best', time_plot=False)
        make_plot_all(df_average, 'average', time_plot=False)
        make_plot(df_average, 'average', time_plot=False)
        make_plot_all(df_worst, 'worst', time_plot=False)
        make_plot(df_worst, 'worst', time_plot=False)
        plt.title(title)

        plt.savefig(os.path.join(
            'plot\\algorithm_info\\' + title, 'all_cases_count' + '.png'))
        plt.close()

    compare_algorithm_plot(complexity_dict)
    compare_algorithm_plot(complexity_dict, time_plot=False)


def main():
    data_plot()


if __name__ == "__main__":
    main()
