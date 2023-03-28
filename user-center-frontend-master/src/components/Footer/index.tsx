import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import {GITHUB_ACCOUNT} from "@/constants";
const Footer: React.FC = () => {
  const defaultMessage = '@2022WHQ出品';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'userManage', // 只要值唯一就可以
          title: '用户管理', // 展现内容
          href: GITHUB_ACCOUNT, // 内容链接
          blankTarget: true, // 是否在新页面打开
        },
        {
          key: 'Ant Design',
          title: '联系管理员',
          href: GITHUB_ACCOUNT,
          blankTarget: true,
        },
        {
          key: 'github',
          title: <><GithubOutlined />whqtt GitHub</>,
          href: GITHUB_ACCOUNT,
          blankTarget: true,
        }
      ]}
    />
  );
};
export default Footer;
