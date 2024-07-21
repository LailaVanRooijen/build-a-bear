const Panel: React.FC<PanelProps> = ({ children, style }) => {
  return <div className={style}>{children}</div>;
};

export default Panel;

interface PanelProps {
  children?: React.ReactNode;
  style?: string;
}
